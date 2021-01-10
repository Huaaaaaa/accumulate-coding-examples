package com.design.pattern.behavioral.visitor.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 通过多态实现
 * Time 8:18
 */
public class ToolApplication {

    public static void main(String[] args) {
        /**
         * 通过重写抽象类中的extract2txt方法，利用多态特性，根据对象的实际类型，来决定执行哪个方法。
         * 缺点：
         * 违背开闭原则，添加一个新的功能，所有类的代码都要修改；
         * 虽然功能增多，每个类的代码都不断膨胀，可读性和可维护性都变差了；
         * 把所有比较上层的业务逻辑都耦合到 PdfFile、PPTFile、WordFile 类中，导致这些类的职责不够单一，变成了大杂烩。
         */
        List<ResourceFile> resourceFiles = getResources();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.extract2txt();
        }
    }

    private static List<ResourceFile> getResources() {

        ArrayList<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PdfFile("E://a.pdf"));
        resourceFiles.add(new WordFile("E://b.word"));
        resourceFiles.add(new PptFile("E://c.ppt"));
        return resourceFiles;


    }
}
