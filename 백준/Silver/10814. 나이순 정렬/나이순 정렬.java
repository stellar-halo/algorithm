import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Person[] p = new Person[n];
        for (int i = 0; i < n; i++) {
            p[i] = new Person();
            String[] tmp = br.readLine().split(" ");
            p[i].setAge(Integer.parseInt(tmp[0]));
            p[i].setName(tmp[1]);
            p[i].setIndex(i);
        }
        Arrays.sort(p);

        for (int idx = 0; idx < n; idx++) {
            bw.write(p[idx].getAge() + " " + p[idx].getName() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Person implements Comparable {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int age = 0;
    private String name = "";
    private int index = -1;

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        if (this.age == person.getAge()) {
            if (this.index < person.getIndex()) return -1;
            else return 1;
        } else if (this.age < person.getAge()) return -1;
        else return 1;
    }
}