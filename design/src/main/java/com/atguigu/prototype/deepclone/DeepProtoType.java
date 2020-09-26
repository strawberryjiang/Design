package com.atguigu.prototype.deepclone;

import java.io.*;

public class DeepProtoType implements Serializable, Cloneable {

    public String name;
    public DeepCloneableTarget deepCloneableTarget;

    public DeepProtoType() {
        super();
    }


    //深拷贝方式一：使用clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //完成对基本数据类型属性和String的克隆
        Object deep=super.clone();
        //对引用类型的属性进行单独处理
        DeepProtoType deepProtoType=(DeepProtoType)deep;
        deepProtoType.deepCloneableTarget= (DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }


    //深拷贝方式二：使用序列化

    protected Object deepClone() throws Exception {
        ByteArrayOutputStream bos=null;
        ObjectOutputStream oos=null;
        ByteArrayInputStream bis=null;
        ObjectInputStream ois=null;
        try {
            bos=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(bos);
            //序列化
            oos.writeObject(this);

            //反序列化
            bis=new ByteArrayInputStream(bos.toByteArray());
            ois=new ObjectInputStream(bis);
            DeepProtoType copyObj = (DeepProtoType)ois.readObject();
            return copyObj;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            bos.close();
            oos.close();
            bis.close();
            ois.close();

        }
    }
}
