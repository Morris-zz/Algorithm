package web.load.balance.algorithm;

import web.load.balance.BaseLoadBalanceAlgorithm;
import web.load.balance.ProviderConfig;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author: morris
 * @Date: 2020/7/28 11:25
 * @description Hash一致性负载均衡
 * @reviewer
 */
public class UniformityHashAlgorithm extends BaseLoadBalanceAlgorithm {
    public static final String HOST_IP_NODE ="%s:%s&&node$d";
    public static final int VIRTUAL_NODE = 5;
    @Override
    public ProviderConfig select(List<ProviderConfig> configs, Object o) {
        //定义一个对key排序的红黑树
        SortedMap<Integer, ProviderConfig> hashMap = new TreeMap<>();
        configs.stream().forEach(config ->{
            for (int i = 0; i < VIRTUAL_NODE; i++) {
                String key = String.format(HOST_IP_NODE, config.getHost(), config.getPort(), i);
                hashMap.put(caculHash(key),config);
            }
        });
        //获取请求ip的hash值
        int requestHash = caculHash((String) o);
        //在红黑树中找到该hashkey最靠近的并大的key，先获取所有比requestHash大的key
        SortedMap<Integer, ProviderConfig> subMap = hashMap.subMap(requestHash, Integer.MAX_VALUE);

        if (subMap.size() != 0){
            Integer firstKey = subMap.firstKey();
            System.out.println("run subMap");
            return subMap.get(firstKey);
        }else {
            return hashMap.get(hashMap.firstKey());
        }

    }

    /**
     * hashcode算法
     * @param str
     * @return
     */
    private int caculHash(String str){
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < str.length(); i++){
            hash = (hash ^ str.charAt(i)) * p;
        }

        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0){
            hash = Math.abs(hash);
        }

        return hash;

    }
}
