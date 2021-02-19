package com.design.pattern.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo:
 * Time 20:08
 */
public class DeepCopySerialize {

    public static void main(String[] args) {
        cloneDeepCopy();
    }

    private static void cloneDeepCopy() {
        System.out.println("使用clone方法实现深拷贝");
        SerializeSon son = getSon();
        SerializeOriginPeople p1 = new SerializeOriginPeople("张飒", 20, 300L, 5000000.00, son);
        Long startTime = System.currentTimeMillis();
        SerializeOriginPeople p2 = p1.deepClone();
        SerializeOriginPeople p3 = p1.deepClone();
        SerializeOriginPeople p4 = p1.deepClone();
        SerializeOriginPeople p5 = p1.deepClone();
        System.out.println("timeUsed=" + (System.currentTimeMillis() - startTime));//0
        System.out.println("p1=" + p1.toString() + "=== p1.hashCode=" + p1.hashCode() + "=== p1.son.hashCode=" + p1.getSon().hashCode());
        System.out.println("p2=" + p2.toString() + "=== p2.hashCode=" + p2.hashCode() + "=== p2.son.hashCode=" + p2.getSon().hashCode());
        System.out.println("p3=" + p3.toString() + "=== p3.hashCode=" + p3.hashCode() + "=== p3.son.hashCode=" + p3.getSon().hashCode());
        System.out.println("p4=" + p4.toString() + "=== p4.hashCode=" + p4.hashCode() + "=== p4.son.hashCode=" + p4.getSon().hashCode());
        System.out.println("p5=" + p5.toString() + "=== p5.hashCode=" + p5.hashCode() + "=== p5.son.hashCode=" + p5.getSon().hashCode());
        System.out.println("p1" + (p1 == p2 ? "等于" : "不等于") + "p2" + "----" + "p1.son" + (p1.getSon() == p2.getSon() ? "等于" : "不等于") + "p2.son");
    }

    private static SerializeSon getSon() {
        SerializeSon son = new SerializeSon("张飒儿子", 2, 20000l);
        return son;
    }
}

@Data
@AllArgsConstructor
class SerializeOriginPeople implements Serializable {

    private static final long serialVersionUID = -5093044638424645440L;
    private String name;

    private Integer age;

    private Long idNo;

    private Double deposit;

    private SerializeSon son;

    public SerializeOriginPeople deepClone() {
        SerializeOriginPeople people = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            people = (SerializeOriginPeople) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return people;
    }

}

@Data
@AllArgsConstructor
class SerializeSon implements Serializable {

    private static final long serialVersionUID = 8822541756543544620L;
    private String name;

    private Integer age;

    private Long idNo;

}
