package com.study.java.sub;

import com.study.java.base.Shap;

/**
 * 在Java中有两种形式可以实现多态。继承和接口。
 *
 * 1、基于继承实现的多态
 * 2、基于接口实现的多态(就不赘述了)
 */
public class Square extends Shap {

    /**
     * Override 方法的重写规则
     * 参数列表与被重写方法的参数列表必须完全相同。
     * 返回类型与被重写方法的返回类型可以不相同，但是必须是父类返回值的派生类（java5 及更早版本返回类型要一样，java7 及更高版本可以不同）。
     * 访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为 public，那么在子类中重写该方法就不能声明为 protected。
     * 父类的成员方法只能被它的子类重写。
     * 声明为 final 的方法不能被重写。
     * 声明为 static 的方法不能被重写，但是能够被再次声明。
     * 子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为 private,static和 final 的方法。
     * 子类和父类不在同一个包中，那么子类只能够重写父类的声明为 public 和 protected 的非 final 方法。
     * 重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常，反之则可以。
     * 构造方法不能被重写。
     * 如果不能继承一个类，则不能重写该类的方法。
     */
    @Override
    public void draw() {
        System.out.println("draw square!");
    }

    /**
     * 声明为 static 的方法不能被重写，但是能够被再次声明。
     * 如果父类子类有相同的静态方法，在调用时候会用变量声明的类型的静态方法！！！
     */
    public static Object getObj() {
        return "test";
    }

    public void draw(int length) {
        System.out.println("draw square with length : " + length);
    }

}