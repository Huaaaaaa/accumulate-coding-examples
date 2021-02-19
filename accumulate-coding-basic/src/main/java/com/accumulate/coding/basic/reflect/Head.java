package com.accumulate.coding.basic.reflect;

import java.io.Serializable;

/**
 * @Author: Huaaaaaa
 * Date:  2020/11/28
 * Todo:
 * Time 10:54
 */
public class Head implements Serializable {


    private static final long serialVersionUID = -270329941295666186L;
    /**
     * 眼睛
     */
    private String eye;

    /**
     * 鼻子
     */
    private String noise;

    /**
     * 耳朵
     */
    private String ear;

    /**
     * 嘴巴
     */
    private String mouth;

    /**
     * 脸
     */
    private String face;

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public String getEar() {
        return ear;
    }

    public void setEar(String ear) {
        this.ear = ear;
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Head{");
        sb.append("eye='").append(eye).append("'");
        sb.append(",noise='").append(noise).append("'");
        sb.append(",ear='").append(ear).append("'");
        sb.append(",mouth='").append(mouth).append("'");
        sb.append(",face='").append(face).append("'");
        sb.append("}");
        return sb.toString();
    }
}
