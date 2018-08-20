package org.alan.gene.pattern;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapOutputCollector.Context;
import org.apache.hadoop.mapreduce.Mapper;

public class IdentityMapper extends  Mapper<Object, Text, Text, Text> {
    private Text g = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
        String[] temp = value.toString().split(",");

        temp[2]= temp[2].trim();
        
        String regex ="A.+A.+C.+T.+G.+A.+C.+T.+G.+G.+T.+C";
        Matcher matcher = Pattern.compile(regex).matcher(temp[2].toString());
        while (matcher.find()) {
        	
        
        	g.set(temp[2]);
        	context.write(new Text(temp[0]),g);
         
        }
        
        

    }
}