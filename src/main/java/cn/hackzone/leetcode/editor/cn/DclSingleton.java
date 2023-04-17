package cn.hackzone.leetcode.editor.cn;

/**
 * DCL 单例
 *
 * @author maxwell
 * @date 2023/03/13
 */
public class DclSingleton {
    private volatile static DclSingleton instance;

    public DclSingleton getSingleton() {
        // 判空，避免不必要的加锁
        if (instance == null) {
            synchronized (DclSingleton.class) {
                //避免重复创建
                if (instance == null) {
                    instance = new DclSingleton();
                    return instance;
                }
            }
        }
        return instance;
    }

}
