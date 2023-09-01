package io.ituknown.dynamic.config;

/**
 * 动态数据源 Holder
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @since 2023/09/01 16:12
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<DataSourceType> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void set(DataSourceType dbType) {
        CONTEXT_HOLDER.set(dbType);
    }

    public static DataSourceType get() {
        return CONTEXT_HOLDER.get();
    }

    public static void useMaster() {
        set(DataSourceType.MASTER);
    }

    public static void useSlave() {
        set(DataSourceType.SLAVE);
    }

    public static void clear() {
        CONTEXT_HOLDER.remove();
    }
}
