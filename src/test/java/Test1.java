public class Test1 {
    public static void main(String[] args) {
        String value = "1.74.103.143\\t2018-12-20 18:12:00\\t\\\"GET /class/130.html HTTP/1.1\\\"\\t404\\thttps://search.yahoo.com/search?p=Flinkʵս";
        String[] data = value.split("\\\\t");
        System.out.println(data[2]);
        System.out.println(data[1]);
        for (String s:data){
            System.out.println(s);
        }
    }
}
