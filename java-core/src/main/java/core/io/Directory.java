package main.java.core.io;

import net.mindview.util.PPrint;
import net.mindview.util.Print;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-03 17:26:26
 * @Modified By:
 */
public final class Directory {
    public static File[] local(File dir, final String regx){
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regx);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, final String regx){
        return local(new File(path), regx);
    }

    public static class TreeInfo implements Iterable<File>{
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.listIterator();
        }

        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        public String toString(){
            return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static TreeInfo walk(File start, String regx){
        return recurseDir(start, regx);
    }

    public static TreeInfo walk(String start, String regx){
        return recurseDir(new File(start), regx);
    }

    public static TreeInfo walk(File start){
        return recurseDir(start, ".*");
    }

    public static TreeInfo walk(String start){
        return recurseDir(new File(start), ".*");
    }

    private static TreeInfo recurseDir(File startDir, String regx){
        TreeInfo result = new TreeInfo();
        for (File item : Objects.requireNonNull(startDir.listFiles())) {
            if (item.isDirectory()){
                result.dirs.add(item);
                result.addAll(recurseDir(item, regx));
            } else if (item.getName().matches(regx)){
                result.files.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        if (args.length == 0){
////            System.out.println(walk("./src/main/java/core/io/"));
////        } else{
////            System.out.println(walk(args[0]));
////        }
//        PPrint.pprint(walk(".").dirs);
        for (File file : local(".", "T.*")) {
            Print.print(file.getName());
        }
        System.out.println("====================");
        for (File file : walk(".", "T.*\\.class")) {
            System.out.println(file);
        }
    }
}
