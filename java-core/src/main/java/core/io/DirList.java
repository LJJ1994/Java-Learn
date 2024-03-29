package main.java.core.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-03 12:58:58
 * @Modified By:
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0){
            list = path.list();
        }else{
            list = path.list(new DirFilter(args[0]));
        }
        assert list != null;
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

class DirFilter implements FilenameFilter{
    private Pattern pattern;
    public DirFilter(String regx){
        pattern = Pattern.compile(regx);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}