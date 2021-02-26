package hutool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.WatchEvent;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileAppender;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.io.watch.SimpleWatcher;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;
import cn.hutool.core.lang.Console;

public class FileUtilClass {
    public static void main(String[] args) {

    }

    // 文件的拷贝
    public static void inAndOut() throws IOException {
        // 文件的拷贝
        BufferedInputStream in = FileUtil.getInputStream("d:/桌面/HuTool学习.md");
        BufferedOutputStream out = FileUtil.getOutputStream("d:/桌面/HuTool学习复制.md");
        long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
        // 拷贝文件的大小
        System.out.println(copySize);
        System.out.println("拷贝成功");
        in.close();
        out.close();
    }

    // 文件类型判断
    public static void getType() {
        File file = FileUtil.file("d:/桌面/HuTool学习.md");
        String type = FileTypeUtil.getType(file);
        // 输出的是文件的格式
        Console.log(type);
    }

    // 文件监听
    public static void watchMonitor() {
        File file = FileUtil.file("example.properties");
        // 这里只监听文件或目录的修改事件
        WatchMonitor watchMonitor = WatchMonitor.create(file, WatchMonitor.ENTRY_MODIFY);
        watchMonitor.setWatcher(new Watcher() {
            public void onCreate(WatchEvent<?> event, Path currentPath) {
                Object obj = event.context();
                Console.log("创建：{}-> {}", currentPath, obj);
            }

            public void onModify(WatchEvent<?> event, Path currentPath) {
                Object obj = event.context();
                Console.log("修改：{}-> {}", currentPath, obj);
            }

            public void onDelete(WatchEvent<?> event, Path currentPath) {
                Object obj = event.context();
                Console.log("删除：{}-> {}", currentPath, obj);
            }

            public void onOverflow(WatchEvent<?> event, Path currentPath) {
                Object obj = event.context();
                Console.log("Overflow：{}-> {}", currentPath, obj);
            }
        });

        // 设置监听目录的最大深入,目录层级大于制定层级的变更将不被监听,默认只监听当前层级目录
        watchMonitor.setMaxDepth(3);
        // 启动监听
        watchMonitor.start();

        // 监听全部事件
        WatchMonitor.createAll(file, new SimpleWatcher() {
            public void onModify(WatchEvent<?> event, Path currentPath) {
                Console.log("EVENT modify");
            }
        }).start();
    }

    // 文件的读写
    public static void readAndWriter() {
        // 可以在构造中传入第二个参数做为编码, 默认编码UTF-8
        FileReader fileReader = new FileReader("d:/桌面/HuTool测试.txt");
        String result = fileReader.readString();
        System.out.println(result);

        // 文件的写入
        FileWriter writer = new FileWriter("d:/桌面/HuTool测试.txt");
        writer.write("添加文本", true);

        // 文件追加
        File file = new File("d:/桌面/HuTool测试.txt");
        FileAppender appender = new FileAppender(file, 16, true);
        appender.append("lolly1023");
        appender.append("追加");
        appender.append("成功");
        appender.flush();
        appender.toString();
    }

}