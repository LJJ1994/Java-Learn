package main.java.core.io;

import java.nio.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 13:39:39
 * @Modified By:
 */
public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        System.out.println("ByteBuffer: ");
        while (bb.hasRemaining()){
            System.out.print(bb.position() + " -> " + bb.get() + ", ");
        }
        System.out.println();

        FloatBuffer fb = ((ByteBuffer) bb.rewind()).asFloatBuffer();
        System.out.println("Float buffer: ");
        while (fb.hasRemaining()){
            System.out.print(fb.position() + " -> " + fb.get() + ", ");
        }
        System.out.println();

        IntBuffer ib = ((ByteBuffer) bb.rewind()).asIntBuffer();
        System.out.println("Int buffer: ");
        while (ib.hasRemaining()){
            System.out.print(ib.position() + " -> " + ib.get() + ", ");
        }
        System.out.println();

        DoubleBuffer db = ((ByteBuffer) bb.rewind()).asDoubleBuffer();
        System.out.println("double buffer: ");
        while (db.hasRemaining()){
            System.out.println(db.position() + " -> " + db.get() + ", ");
        }

        LongBuffer lb = ((ByteBuffer) bb.rewind()).asLongBuffer();
        System.out.println("long buffer: ");
        while (lb.hasRemaining()){
            System.out.println(lb.position() + " -> " + lb.get() + ", ");
        }

        ShortBuffer sb = ((ByteBuffer) bb.rewind()).asShortBuffer();
        System.out.println("short buffer");
        while (sb.hasRemaining()){
            System.out.println(sb.position() + " -> " + sb.get() + ", ");
        }

    }
}
