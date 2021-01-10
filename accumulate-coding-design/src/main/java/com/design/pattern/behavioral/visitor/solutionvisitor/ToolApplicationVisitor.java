package com.design.pattern.behavioral.visitor.solutionvisitor;

import com.design.pattern.behavioral.visitor.solution3.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 通过访问者模式实现
 * Time 8:18
 */
public class ToolApplicationVisitor {

    public static void main(String[] args) {
        /**
         * 一般来说，访问者模式针对的是一组类型不同的对象（PdfFile、PPTFile、WordFile）。
         * 不过，尽管这组对象的类型是不同的，但是，它们继承相同的父类（ResourceFile）或者实现相同的接口。
         * 在不同的应用场景下，我们需要对这组对象进行一系列不相关的业务操作（抽取文本、压缩等），
         * 但为了避免不断添加功能导致类（PdfFile、PPTFile、WordFile）不断膨胀，职责越来越不单一，
         * 以及避免频繁地添加功能导致的频繁代码修改，我们使用访问者模式，将对象与操作解耦，将这些业务操作抽离出来，
         * 定义在独立细分的访问者类（Extractor、Compressor）中。
         *
         * 分析扩展性：
         * 当新增一个压缩功能时，只需如下操作：
         * 1、增加一个压缩功能的访问者VCompressor，实现抽象访问者接口，并提供每种文件的压缩功能
         * 2、在客户端直接通过抽象元素的accept方法接受新增的访问者即可
         * 实在是太妙了！！！！
         *
         *
         * 扩展：（单分派和双分派）
         * 所谓 Single Dispatch，指的是执行哪个对象的方法，根据对象的运行时类型来决定；执行对象的哪个方法，根据方法参数的编译时类型来决定。
         * 所谓 Double Dispatch，指的是执行哪个对象的方法，根据对象的运行时类型来决定；执行对象的哪个方法，根据方法参数的运行时类型来决定
         */
        Visitor vExtractor = new VExtractor();
        Visitor vCompressor = new VCompressor();
        List<VResourceFile> resourceFiles = getResources();
        for (VResourceFile vResourceFile : resourceFiles) {
            vResourceFile.accept(vExtractor);
            vResourceFile.accept(vCompressor);
        }
    }

    private static List<VResourceFile> getResources() {

        ArrayList<VResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new VPdfFile("E://a.pdf"));
        resourceFiles.add(new VWordFile("E://b.word"));
        resourceFiles.add(new VPptFile("E://c.ppt"));
        return resourceFiles;


    }
}
