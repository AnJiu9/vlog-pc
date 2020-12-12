package com.j.vlog.utils;

import com.j.vlog.model.Card;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName DataUtil
 * @Description
 * @Author orange
 * @Date 2020-12-03 14:26
 **/

public class DataUtil {
    public static List<Card> initCards() {
        Card[] cards = new Card[]{
                Card.builder()
                    .id(1)
                    .title("Java学习")
                    .bgImg("https://share--app.oss-cn-hangzhou.aliyuncs.com/avatar/20201205181922.jpg")
                    .content("Java学习")
                    .build(),
                Card.builder()
                    .id(2)
                    .title("Java Script学习")
                    .bgImg("https://share--app.oss-cn-hangzhou.aliyuncs.com/avatar/55354673-67a3-42c8-8db1-d97b203e41bc.JPG")
                    .content("Java Script学习")
                    .build(),
                Card.builder()
                    .id(3)
                    .title("Linux学习")
                    .bgImg("https://student-management-img.oss-cn-hangzhou.aliyuncs.com/bk-image/20201209222820.JPG")
                    .content("Linux学习")
                    .build(),
                Card.builder()
                    .id(4)
                    .title("MySQL学习")
                    .bgImg("https://student-management-img.oss-cn-hangzhou.aliyuncs.com/logo/b8287be3-3f5b-424e-a72a-981795515da2.JPG")
                    .content("MySQL学习")
                    .build(),
                Card.builder()
                    .id(5)
                    .title("Python学习")
                    .bgImg("https://student-management-img.oss-cn-hangzhou.aliyuncs.com/logo/20201123180501.JPG")
                    .content("Python学习")
                    .build(),
        };
        return Arrays.asList(cards);
    }
} 
