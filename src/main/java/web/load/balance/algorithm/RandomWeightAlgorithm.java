package web.load.balance.algorithm;

import web.load.balance.BaseLoadBalanceAlgorithm;
import web.load.balance.ProviderConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 随机权重
 * @Author: morris
 * @Date: 2020/7/27 17:18
 * @description
 * @reviewer
 */
public class RandomWeightAlgorithm extends BaseLoadBalanceAlgorithm {

    @Override
    public ProviderConfig select(List<ProviderConfig> configs, Object o) {

        return select2(configs);

    }

    /**
     * 构造一个新的list，以数量填充list实现权重分配
     * 缺点：空间复杂度大
     *
     * @param configs
     * @return
     */
    private ProviderConfig selectByNumList(List<ProviderConfig> configs) {

        ArrayList<ProviderConfig> providerConfigs = new ArrayList<>();
        configs.stream().forEach(config -> {
            for (int i = 0; i < config.getWeight(); i++) {
                providerConfigs.add(config);
            }
        });
        int random = new Random().nextInt(providerConfigs.size());
        System.out.println(providerConfigs);
        return providerConfigs.get(random);
    }


    /**
     *  构建空间复杂度小的随机权重
     *
     * @param configs
     * @return
     */
    private ProviderConfig select2(List<ProviderConfig> configs) {
        ArrayList<Integer> idx2w = new ArrayList<>();
        int count = 0;
        int i = 0;
        for (ProviderConfig config : configs) {
            count += config.getWeight();
            idx2w.add(count);
//            System.out.println("index:"+ i++ +"weight:"+config.getWeight());
        }
        System.out.println(idx2w);
        Random random = new Random();
        int anInt = random.nextInt(count);
        int index = 0;
        for (int j = 0; j < idx2w.size(); j++) {
            if (anInt < idx2w.get(j)){
                index = j;
                break;
            }
        }
        return configs.get(index);
    }
}
