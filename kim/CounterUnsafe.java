package kim;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * CAS操作通过Unsafe 工具类实现原子性
 */
public class CounterUnsafe {
    volatile int i = 0;
    // 偏移量
    private static long valueOffset;
    private static Unsafe unsafe = null;

    static {
        // 通过反射来获取unsafe工具类
        // TODO：了解反射
        try {
            final Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            try {
                unsafe = (Unsafe) field.get(null);
            } catch (final IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (final IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // 获取i字段偏移量
            final Field iFiled = CounterUnsafe.class.getDeclaredField("i");
            valueOffset = unsafe.objectFieldOffset(iFiled);

        } catch (final NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void add() {
        for (;;) {
            // 拿i字段的当前值
            final int current = unsafe.getIntVolatile(this, valueOffset);
            // 用CAS操作i+1
            if (unsafe.compareAndSwapInt(this, valueOffset, current, current + 1)) {
                break;
            }
        }
    }

}