package com.huhan.blog.utils;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

/**
 * 将markdown文本转成html文本
 * 
 * @author huhan
 * @data 2018/8/29
 */
public class MarkDownUtils {

    /**
     * markdown转换成html格式
     * 
     * @author huhan
     * @data 2018/8/29
     */
    public static String markdownToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        return renderer.render(document);
    }

    /**
     * 增加扩展[标题锚点，表格生成] MarkDown转换HTML
     * 
     * @param
     * @author huhan
     * @data 2018/8/29
     */
    public static String markdownToHtmlExtensions(String markdown) {
        // h标题生产id属性
        Set<Extension> headingAnchorExtension = Collections.singleton(HeadingAnchorExtension.create());
        // 转换table的html
        List<Extension> tableExtension = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder().extensions(tableExtension).build();

        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(headingAnchorExtension).extensions(tableExtension)
            .attributeProviderFactory(new AttributeProviderFactory() {
                @Override
                public AttributeProvider create(AttributeProviderContext context) {
                    return new CustomAttributeProvider();
                }
            }).build();
        return renderer.render(document);
    }

    /**
     * 处理标签的属性
     *
     * @author huhan
     * @data 2018/8/29
     */
    static class CustomAttributeProvider implements AttributeProvider {

        @Override
        public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
            // 改变a标签中的target属性值为_blank
            if (node instanceof Link) {
                attributes.put("target", "_blank");
            }
            if (node instanceof TableBlock) {
                attributes.put("class", "ui celled table");
            }
        }
    }
}
