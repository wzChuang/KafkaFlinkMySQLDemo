import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Test {
    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        String filePath = "C:\\MyProgram\\Project\\KafkaFlinkMySQLDemo\\src\\test\\java\\file1.txt";
        DataStream<String> input = env.readTextFile(filePath);
        input.print();
        DataStream<Integer> parsed = input.map(new MapFunction<String, Integer>() {
            @Override
            public Integer map(String value) {
                return Integer.parseInt(value);
            }
        });
        parsed.print();

    }
}
