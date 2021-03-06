package web.load.balance;

import web.load.balance.algorithm.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: morris
 * @Date: 2020/7/27 16:31
 * @description
 * @reviewer
 */
public class LoadBalanceApplication {
    public static void main(String[] args) {
//        loadBalance(new RandomAlgorithm(),20,100);
//        loadBalance(new RandomWeightAlgorithm(),20,100);
//        loadBalance(new PollAlgorithm(),20,100);
//        loadBalance(new PollingWeightAlgorithm(),9,1000);
//        loadBalance(new LeastActiveAlgorithm(),9,100);
        loadBalance(new UniformityHashAlgorithm(),9,100);
    }

    /**
     * 测试 loadBalance 方法
     * @param strategy
     * @param configNum
     * @param testCount
     */
    public static void loadBalance(BaseLoadBalanceAlgorithm strategy, int configNum, int testCount){

        List<ProviderConfig> configs = new ArrayList<>();
        int[] counts = new int[configNum];


        for(int i = 0; i< configNum; i++){
            ProviderConfig config = new ProviderConfig();
            config.setInterfaceName("com.serviceImpl");
            config.setHost("127.0.0."+i);
            config.setPort(i);
            config.setWeight(new Random().nextInt(100));
            config.setCallTime(new Random().nextInt(100));
            configs.add(config);

        }

        //System.out.println(configs);

        for(int i = 0; i< testCount ; i++){
            ProviderConfig config = strategy.select(configs,"127.0.0."+i);
            // System.out.println("选中的:"+config);
            Integer count = counts[config.getPort()];
            counts[config.getPort()] = ++count;

        }

        for(int i = 0; i< configNum; i++){
//            System.out.println("序号:" + i + " 权重：" + configs.get(i).getWeight() + "--次数：" + counts[i]);
//            System.out.println("序号:" + i + " 耗时：" + configs.get(i).getCallTime() + "--次数：" + counts[i]);
            System.out.println("序号:" + i + " ip：" + configs.get(i).getHost() + "--次数：" + counts[i]);
        }
    }


}
