package web.load.balance.algorithm;

import web.load.balance.BaseLoadBalanceAlgorithm;
import web.load.balance.ProviderConfig;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: morris
 * @Date: 2020/7/28 9:42
 * @description 最小延迟算法：达到分布式中将延迟大的应用服务器命中率降低，延迟小的命中率提升。提供更快的响应速度。
 * @reviewer
 */
public class LeastActiveAlgorithm extends BaseLoadBalanceAlgorithm {
    @Override
    public ProviderConfig select(List<ProviderConfig> configs, Object o) {
        ProviderConfig[] providerArray = new ProviderConfig[configs.size()];
        configs.toArray(providerArray);
        Arrays.sort(providerArray, Comparator.comparing(ProviderConfig::getCallTime));
        System.out.println(providerArray);
        return providerArray[0];
    }
}
