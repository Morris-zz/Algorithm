package web.load.balance.algorithm;

import web.load.balance.BaseLoadBalanceAlgorithm;
import web.load.balance.ProviderConfig;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 轮询算法
 * @Author: morris
 * @Date: 2020/7/27 18:07
 * @description
 * @reviewer
 */
public class PollAlgorithm extends BaseLoadBalanceAlgorithm {
    private ConcurrentHashMap<String, Integer> indexMap = new ConcurrentHashMap();

    @Override
    public ProviderConfig select(List<ProviderConfig> configs, Object o) {
        Integer index = indexMap.get(configs.get(0).getInterfaceName());
        if (index == null) {
            indexMap.put(configs.get(0).getInterfaceName(), 0);
            index = 0;
        } else {
            index++;
            if (index >= configs.size()) {
                index = 0;
            }
            indexMap.put(configs.get(0).getInterfaceName(), index);
        }
        return configs.get(index);
    }
}
