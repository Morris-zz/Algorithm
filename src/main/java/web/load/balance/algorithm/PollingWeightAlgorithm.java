package web.load.balance.algorithm;

import web.load.balance.BaseLoadBalanceAlgorithm;
import web.load.balance.ProviderConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: morris
 * @Date: 2020/7/27 18:26
 * @description
 * @reviewer
 */
public class PollingWeightAlgorithm extends BaseLoadBalanceAlgorithm {
    /** 缓存并分类提供者当前索引 */
    private ConcurrentHashMap<String,Integer> indexMap = new ConcurrentHashMap<>();

    @Override
    public ProviderConfig select(List<ProviderConfig> configs, Object o) {
        String providerName = configs.get(0).getInterfaceName();
        Integer index = indexMap.get(providerName);
        if (index == null){
            index = 0;
            indexMap.put(providerName,index);
            return configs.get(index);
        }else {
            index++;
            //权重策略：将权重设为list个数
            ArrayList<ProviderConfig> newConfigs = new ArrayList<>();
            configs.stream().forEach(config ->{
                for (int i = 0; i < config.getWeight(); i++) {
                    newConfigs.add(config);
                }
            });
            if (index > newConfigs.size() -1){
                index = 0;
            }
            indexMap.put(providerName,index);
            return newConfigs.get(index);
        }
    }
}
