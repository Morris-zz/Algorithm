package design.responsibility.impl;

import design.responsibility.BaseRule;

/**
 * @Author: morris
 * @Date: 2020/8/17 17:36
 * @reviewer
 */
public class BasicRule extends BaseRule {
    @Override
    public Boolean evaluate(Object context) {
        return null;
    }

    @Override
    public void execute(Object context) {
        //do something
        System.out.println("执行basic规则");
    }
}
