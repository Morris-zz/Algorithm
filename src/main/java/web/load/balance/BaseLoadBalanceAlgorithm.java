package web.load.balance;

import java.util.List;

/**
 * @Author: morris
 * @Date: 2020/7/27 16:40
 * @description
 * @reviewer
 */
public abstract class BaseLoadBalanceAlgorithm {

    /**
     * load balance common method to select provider from List<ProviderConfig></ProviderConfig>
     * @param configs list<ProviderConfig></ProviderConfig>
     * @param o extra parameters
     * @return one ProviderConfig
     * @see ProviderConfig
     */
    public abstract ProviderConfig select(List<ProviderConfig> configs, Object o);

}
