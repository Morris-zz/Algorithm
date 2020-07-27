package web.load.balance.algorithm;

import web.load.balance.BaseLoadBalanceAlgorithm;
import web.load.balance.ProviderConfig;

import java.util.List;
import java.util.Random;

/**
 * @Author: morris
 * @Date: 2020/7/27 16:59
 * @description 随机数均衡算法，直接选取随机数 算法简单
 * @reviewer
 */
public class RandomAlgorithm extends BaseLoadBalanceAlgorithm {
    @Override
    public ProviderConfig select(List<ProviderConfig> configs, Object o) {
        Random random = new Random();
        int r = random.nextInt(configs.size());
        return configs.get(r);
    }
}
