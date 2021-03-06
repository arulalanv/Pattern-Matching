package org.alan.gene.pattern;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapOutputCollector.Context;
import org.apache.hadoop.mapreduce.Reducer;

public class IdentityReducer extends Reducer<Text, IntWritable, Text, Text>{
	public void reduce(Text key, Iterable<Text> values,
            Context context) throws IOException, InterruptedException {
        

        for (Text gene: values){
        	context.write(key,gene);
        }

        
    }
}