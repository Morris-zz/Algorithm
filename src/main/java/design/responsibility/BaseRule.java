package design.responsibility;

/**
 * @Author: morris
 * @Date: 2020/8/17 17:28
 * @reviewer
 */
public abstract class BaseRule<CORE_ITEM,T> {

    /**
     * 是否经过该rule
     * @param context
     * @return
     */
    public abstract Boolean evaluate(T context);

    /**
     * 执行
     * @param context
     */
    public abstract void execute(T context);
}
