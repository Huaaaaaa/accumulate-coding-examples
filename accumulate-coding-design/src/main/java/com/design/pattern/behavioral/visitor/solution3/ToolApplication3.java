package com.design.pattern.behavioral.visitor.solution3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 通过方法重载+双分派实现
 * Time 8:18
 */
public class ToolApplication3 {

    public static void main(String[] args) {
        /**
         * ●通过重载抽象类中的extract2txt方法，传入具体的Resource对象，执行其方法
         * ●在抽象元素中定义一个接收访问者的方法，在具体元素中实现该方法时，给访问者的具体方法传入当前具体元素的类型
         * 在执行第 resourceFile.accept(extractor3);这段代码的时候，根据多态特性，程序会调用实际类型的 accept 函数，
         * 比如 PdfFile3 的 accept 函数，也就是extractor3.extract2txt(this);这段代码。
         * 而这段代码中的 this 类型是 PdfFile3 的，在编译的时候就确定了，所以会调用 extractor 的 extract2txt(PdfFile3 pdfFile3) 这个重载函数。
         * 扩展性分析：
         * 此时如果需要增肌新功能压缩：Compressor,需执行如下操作：
         * 1、增加一个访问者Compressor
         * 2、抽象元素中增加接受访问者Compressor的方法，并在具体元素中实现
         *
         * 存在的问题：
         * 上面代码还存在一些问题，添加一个新的业务，还是需要修改每个资源文件类，违反了开闭原则。
         *
         * 解决方案：
         * 针对这个问题，我们抽象出来一个 Visitor 接口，包含是三个命名非常通用的 visit() 重载函数，分别处理三种不同类型的资源文件。
         * 具体做什么业务处理，由实现这个 Visitor 接口的具体的类来决定，比如 Extractor 负责抽取文本内容，Compressor 负责压缩。
         * 当我们新添加一个业务功能的时候，资源文件类不需要做任何修改，只需要修改 ToolApplication 的代码就可以了。
         */
        Extractor3 extractor3 = new Extractor3();
        Compressor compressor = new Compressor();
        List<ResourceFile3> resourceFiles = getResources();
        for (ResourceFile3 resourceFile : resourceFiles) {
            resourceFile.accept(extractor3);
            resourceFile.accept(compressor);
        }
    }

    private static List<ResourceFile3> getResources() {

        ArrayList<ResourceFile3> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PdfFile3("E://a.pdf"));
        resourceFiles.add(new WordFile3("E://b.word"));
        resourceFiles.add(new PptFile3("E://c.ppt"));
        return resourceFiles;


    }
}
