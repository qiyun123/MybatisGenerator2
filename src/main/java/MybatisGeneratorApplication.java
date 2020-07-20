import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MybatisGeneratorApplication {

    public static void main(String[] args) {
        List<String> warnings = new ArrayList<>();
        // 配置文件路径
        String xmlPath = "\\src\\main\\resources\\generatorConfig.xml";
        try {
            // System.getProperty("user.dir"),获取当前的工作路径，windows和linux里的路径格式不一致，这里用来转换，windows的是左斜杠，linux是右斜杠
            String configFilePath = System.getProperty("user.dir").concat(
                    isNotWindows() ? xmlPath.replaceAll("\\\\", "/") : xmlPath);
            boolean overwrite = true;
            File configFile = new File(configFilePath);
            // configFile.exists():测试此抽象路径名表示的文件或目录是否存在, isFile() :表示测试此抽象路径名表示的文件是否是一个标准文件。
            // 创建配置解析器
            ConfigurationParser cp = new ConfigurationParser(warnings);
            // 调用解析器创建配置对象()
            Configuration config = cp.parseConfiguration(configFile);
            // 创建一个ShellCallback对象，shellCallback接口是处理文件的创建和合并，默认是不支持文件合并的。
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            // 创建一个MyBatisGenerator对象。MyBatisGenerator类是真正用来执行生成动作的类
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isNotWindows() {
        // System.getProperty("os.name") 获取当前运行的系统名称
        return !System.getProperty("os.name").toLowerCase()
                .startsWith("windows");
    }

}