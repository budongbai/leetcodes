package algorithm.daily;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/">1016. 子串能表示从 1 到 N 数字的二进制串</a>
 * <p></p>
 * 给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数，其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回 false 。
 * <p>
 * 子字符串 是字符串中连续的字符序列。
 */
public class L1016 {
    public static boolean queryString(String s, int n) {
        // 将s转换为正整数
        int num = Integer.parseInt(s, 2);
        // 判断n是否小于s，小于的话就是包含
        return num >= n;
    }



    public static Map<String, String> parseMagicUrlParam(String magicUrl) {
        String magicUrlPattern = "^.*(deadpool(_[A-Za-z0-9]+)*.html)\\\\?.+";
        if (!magicUrl.matches(magicUrlPattern)) {
            return null;
        }

        Map<String, String> result = new HashMap<>();
        String[] paramParts = magicUrl.substring(magicUrl.indexOf('?') + 1).split("&");
        for (String paramPart : paramParts) {
            String[] pair = paramPart.split("=");
            if (pair.length >= 1) {
                result.put(pair[0], pair.length >= 2 ? pair[1] : "");
            }
        }
        return result;
    }

    public static String getPageIdByUrl(String url) throws UnsupportedEncodingException {
        final String charset = "utf-8";

            url = URLDecoder.decode(url, charset);


            return url;

    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(getPageIdByUrl("https://mobile.ddlequ.com/deadpool.html?id=96455&_pdd_tc=ffffff&access_from=home&_pdd_fs=1&_pdd_sbs=1&_scene=23&adSpaceId=2242&position=1&cubeRewardType=0&_x_refer_cpt_ad=1&directSceneId=2242&adId=5417150832&_ex_banner_idx=0&_ex_banner_middle=NTQxNzE1MDgzMjozOTM3Mzg3NDkxOjYyMTEwMDAzMjoxNDo1MzIzNTQ6MzQ4NTQwODQyOTE6MjI0MjoyOjE6NjQ1NjkzNTQxOTpDZHY4YnhuRHdTMklPbEE0Q2hnZlFLX2VXa2pWRGlMMGEyS1dzMU1vLTB4QXJYR0NzLUpVYTF2aHdzN2VENm9BOi0xOjA6MzozOjM6MTE4Og"));
    }
}
