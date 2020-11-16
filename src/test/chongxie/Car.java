package src.test.chongxie;

/**
 * @description:
 * @author: ttao
 * @create: 2020-07-16 10:28
 **/
public class Car {


    public  void    buildCar(){
        System.out.println("Car类开始构造汽车");
        bulidfdj();
        System.out.println("Car类结束构造汽车");

    }
    protected void bulidfdj(){
        System.out.println("Car类结束构造汽车---构造发动机");
    }

}


class  SmallCar extends  Car{
    public static void main(String[] args) {
        SmallCar smallCar=new SmallCar();
        smallCar.buildCar();
    }

    @Override
    public void buildCar() {
        System.out.println("Car类开始构造汽车");
        bulidfdj();
        System.out.println("Car类结束构造汽车");
    }
    @Override
    protected void bulidfdj(){
       //super.bulidfdj();
        System.out.println("SmallCar类结束构造汽车---构造发动机");
    }

}
