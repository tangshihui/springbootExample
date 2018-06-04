import com.tsh.example.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xmlunit.util.Convert;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {com.tsh.example.ExampleApplication.class})
public class AppTest {


    @Test
    public void encrypt() {
    }

    @Autowired
    UserService userService;

    @Test
    public void getAppId() {

        userService.setAppId("dafsdfsa");

        System.out.println("=============>appId:" + userService.getAppId());
    }

    @Test
    public void session() {

    }

    @Autowired
    @Qualifier("cat")
    Animal cat;

    @Autowired
    BigCat bigCat;


    @Test
    public void testAnimal() {
        cat.eat();

        bigCat.eat();
    }

    @Test
    public void testStream() throws InterruptedException {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("dog1", 1));
        dogs.add(new Dog("lll", 2));
        dogs.add(new Dog("tt", 2));
        dogs.add(new Dog("lala", 2));


        System.out.println("before stream");
        dogs.forEach(s -> System.out.println(s));
        System.out.println("use stream");
        List<Dog> dogsNew = dogs.stream().map(s -> {
            s.setName("Lucy");
            return s;
        }).collect(Collectors.toList());
        dogsNew.forEach(s -> System.out.println(s));

        System.out.println("use stream set name");
        //dogs.stream().forEach(s->s.setName(s.getName()+s.getAge()));
        dogs.forEach(s -> s.setName(s.getName() + s.getAge()));

        dogs.stream().forEach(s -> System.out.println(s));
        dogs.forEach(s -> System.out.println(s));

        dogs.stream()
                .map(s -> s.getAge())
                .forEach(s -> System.out.println(s));

        System.out.println("=======>size:" + dogs.size());
        String words = "abcdefjhijklmnopqrstuvwxyz1234567890";


        boolean existsLittle = dogs.stream().anyMatch(s -> s.getAge() < 2);
        System.out.println("existsLittle:" + existsLittle);

        boolean existsAll = dogs.stream().allMatch(s -> s.getAge() < 2);
        System.out.println("existsAll:" + existsAll);

        for (int i = 0; i < 1000; i++) {
            cat.eat();
            System.out.println(i);
            Thread.sleep(200);
        }
    }

    @Test
    public void testSystem() {
        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("JAVA_HOME"));

        Map<String, String> envMap = System.getenv();

        for (Map.Entry<String, String> entry : envMap.entrySet()) {
            System.out.println("[" + entry.getKey() + ":" + entry.getValue() + "]");
        }


    }

    @Test
    public void dateTest() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        int month = 4;
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        System.out.println("tday:" + format.format(today));
        System.out.println("yesterday:" + format.format(yesterday));


        calendar.set(calendar.DAY_OF_MONTH, 1);

        System.out.println("now:" + format.format(calendar.getTime()));

        calendar.add(Calendar.MONTH, month);
        Date endTime = calendar.getTime();
        System.out.println("after " + month + " month:" + format.format(calendar.getTime()));

        calendar.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println("after " + month + " month last day:" + format.format(calendar.getTime()));

        calendar.set(Calendar.DAY_OF_MONTH, 12);
        System.out.println(calendar.getTime());  //此处是6.12
        calendar.set(Calendar.DAY_OF_MONTH, 0);  //此处是5.31

        System.out.println(calendar.getActualMaximum(Calendar.DATE));
//此处是5月份的31天
        System.out.println(calendar.getTime()); //此处是5.31

        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));


        System.out.print(format.format(calendar.getTime()));

    }

    @Test
    public void testThread() {
        String info = getInfo();

        System.out.println(info);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getInfo() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("in thread...");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        return "Success";
    }


    @Test
    public void testPage() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);

        list.subList(0, 5).forEach(s -> System.out.println(s));
        list.subList(5, 10).forEach(s -> System.out.println(s));
        list.subList(10, 12).forEach(s -> System.out.println(s));

        /*int pageSize=5;

       int a= list.size()/pageSize;
        System.out.println(list.size());

        //list.subList(0,0).forEach(s-> System.out.println(s));
        int totalPage=(int)Math.ceil((double)(list.size()/(double)pageSize));
        System.out.println("totalPage:"+totalPage);
        for (int i = 0; i < totalPage; i++) {
            int start=i*pageSize;
            int end=start+pageSize;

            if(end>=list.size()){
                end=list.size();
                System.out.println("最大index:"+end);
            }
            System.out.println("start:"+start+ " end:"+end);
            System.out.println("第"+(i+1)+"页");
            display(list.subList(start,end));
        }
        //list.subList(0,5).forEach(s-> System.out.println(s));
        //list.forEach(s-> System.out.println(s));*/

    }

    private void display(List<Integer> list) {
        list.forEach(s -> System.out.println(s));
    }


    @Autowired
    UserServiceImpl userServiceImpl;

    @Test
    public void testInnerException() {

        Map<String, Integer> map = new HashMap<>();
        map.put("tsh", 1);
        map.put("ths", 2);
        System.out.println("=========>map put success");
        try {
            userServiceImpl.getInfo();
        } catch (UserServiceImpl.InfoException ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testReduce() {
        List<String> names = Arrays.asList("tsh", "zxy", "nupt", "Nanjing");
        String str = names.stream().reduce((a, b) -> a + "," + b).get();
        System.out.println(str);
    }

    @Test
    public void testRegex() {
        String right = "gh_6a58e17c1bb2";
        Map<String, Boolean> map = new HashMap<>();
        map.put("fsadfsadf", false);
        map.put("gh_432few", false);
        map.put(" ksf*7%", false);
        map.put("圣兽可分地方 ", false);
        map.put("gh_6a58e17c1bb2V", false);
        map.put("gh_16a58e17c1bb2", false);
        map.put("gh_6a55617c1bb2", false);

        String originId = "^gh_[A-Za-z0-9]{12}";
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            entry.setValue(Pattern.matches(originId, entry.getKey()));
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        boolean validate = Pattern.matches(originId, right);
        System.out.println("======>" + validate);
    }


    @Test
    public void testTime() {

        for (int i = 0; i < 10; i++) {

            System.out.println(new Date().getTime());
        }

    }





    @Test
    public void testTask() {

        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(" ==========> currentThreadID:" + Thread.currentThread().getId() + " index:" + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
       // executorService.shutdown();


        try {
            Thread.sleep(200 * 15);
            System.out.println("==========>main");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
