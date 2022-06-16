package io.ituknown.config;

/**
 * 动态数据源 Holder
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @date 2022/06/16 15:03
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<DataSourceType> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void set(DataSourceType dbType) {
        CONTEXT_HOLDER.set(dbType);
    }

    public static DataSourceType get() {
        return CONTEXT_HOLDER.get();
    }

    public static void clear() {
        CONTEXT_HOLDER.remove();
    }

    public static void useMaster() {
        set(DataSourceType.MASTER);
    }

    public static void useSlave() {
        set(DataSourceType.SLAVE);
    }
}
