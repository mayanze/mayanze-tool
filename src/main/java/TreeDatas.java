
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据转树形数据
 */
public class TreeDatas {
    /**
     * 获取模拟表格数据
     */
    public List<Map<String, Object>> getDatas() {
        List<Map<String, Object>> datas = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", "11");
        map.put("parentId", "1");
        map.put("name", "根节点");

        Map<String, Object> map11 = new HashMap<>();
        map11.put("id", "20");
        map11.put("parentId", "11");
        map11.put("name", "父亲节点1");

        Map<String, Object> map12 = new HashMap<>();
        map12.put("id", "21");
        map12.put("parentId", "11");
        map12.put("name", "父亲节点2");

        Map<String, Object> map21 = new HashMap<>();
        map21.put("id", "210");
        map21.put("parentId", "21");
        map21.put("name", "子亲节点1");

        Map<String, Object> map31 = new HashMap<>();
        map31.put("id", "2100");
        map31.put("parentId", "210");
        map31.put("name", "孙子亲节点1");

        datas.add(map);
        datas.add(map11);
        datas.add(map12);
        datas.add(map21);
        datas.add(map31);
        return datas;
    }

    /**
     * 普通数据转换为树形表格数据
     */
    @Test
    public void getTreeData() {
        List<Map<String, Object>> datas = getDatas();
        List<Map<String, Object>> child = getChild("1", datas);
        System.out.println(child);
    }

    public List<Map<String, Object>> getChild(String parendId, List<Map<String, Object>> datas) {
        List<Map<String, Object>> childList = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            if (parendId.equals(datas.get(i).get("parentId").toString())) {
                childList.add(datas.get(i));
            }
        }
        for (Map<String, Object> stringObjectMap : childList) {
            stringObjectMap.put("children", getChild(stringObjectMap.get("id").toString(), datas));
        }
        return childList;
    }
}
