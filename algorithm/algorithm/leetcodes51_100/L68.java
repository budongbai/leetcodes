package algorithm.leetcodes51_100;

import java.util.ArrayList;
import java.util.List;

public class L68 {
    public List<String> fubudongbaiustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            // list 装载当前行的所有 word
            list.clear();
            list.add(words[i]);
            // 当前单词i的长度
            int cur = words[i++].length();
            // 遍历下一个单词长度+空格小于最大宽度，继续加单词
            while (i < n && cur + 1 + words[i].length() <= maxWidth) {
                cur += 1 + words[i].length();
                list.add(words[i++]);
            }

            // 当前行为最后一行，特殊处理为左对齐
            if (i == n) {
                StringBuilder sb = new StringBuilder(list.get(0));
                for (int k = 1; k < list.size(); k++) {
                    sb.append(" ").append(list.get(k));
                }
                while (sb.length() < maxWidth) sb.append(" ");
                ans.add(sb.toString());
                break;
            }

            // 如果当前行只有一个 word，特殊处理为左对齐
            int cnt = list.size();
            if (cnt == 1) {
                StringBuilder str = new StringBuilder(list.get(0));
                while (str.length() != maxWidth) str.append(" ");
                ans.add(str.toString());
                continue;
            }

            /*
             * 其余为一般情况
             * wordWidth : 当前行单词总长度;
             * spaceWidth : 当前行空格总长度;
             * spaceItem : 往下取整后的单位空格长度
             * remainingSpaceWidth :
             */
            int wordWidth = cur - (cnt - 1);
            int spaceWidth = maxWidth - wordWidth;
            int spaceItemWidth = spaceWidth / (cnt - 1);
            int remainingSpaceWidth = maxWidth - spaceItemWidth * (cnt - 1) - wordWidth;
            StringBuilder spaceItem = new StringBuilder();
            for (int k = 0; k < spaceItemWidth; k++) spaceItem.append(" ");
            StringBuilder sb = new StringBuilder();

            // 遍历当前行的单词列表
            for (int k = 0; k < cnt; k++) {
                String item = list.get(k);
                sb.append(item);
                // 最后一个单词，不需要再加空格了
                if (k == cnt - 1) break;
                sb.append(spaceItem);
                //
                if (remainingSpaceWidth > 0) {
                    sb.append(" ");
                    remainingSpaceWidth--;
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }

}
