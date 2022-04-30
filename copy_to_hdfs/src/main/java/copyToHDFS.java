import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


import java.io.IOException;

public class copyToHDFS {
    public static void main(String[] args) {

        String hdfsSiteXML = "/home/ubuntu/hadoop/etc/hadoop/hdfs-site.xml";
        String coreSiteXML = "/home/ubuntu/hadoop/etc/hadoop/core-site.xml";
        String localfilepath = args[0];
        String hdfstargetpath = args[1];

        Configuration conf = new Configuration();
        conf.addResource(new Path(hdfsSiteXML));
        conf.addResource(new Path(coreSiteXML));

        try {
            FileSystem fs = FileSystem.get(conf);
            fs.copyFromLocalFile(false, true, new Path(localfilepath), new Path(hdfstargetpath));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

}
