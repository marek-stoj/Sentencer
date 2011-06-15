package com.marekstoj.sentencer;

import java.io.IOException;
import java.io.InputStream;
import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class Program {

  private static final String SENTENCE_MODEL_RESOURCE_NAME = "/res/en-sent.bin";
  
  public static void main(String[] args) throws IOException {
    InputStream sentenceModelInputStream = null;

    try {
      String text = "Combined with my coach's blog post made me think about sharing my best practices. Most of this is really a note to myself that I need to keep on learning, but in the spirit of sharing I thought I would put it out there for other people to read and possibly share their own experiences on how they keep up.  Know how to edit text. I don't mean how to bold and italicize. I mean regex, how to find and replace from the keyboard. The faster you can edit the text and the more efficiently you can do that the better you will be at programming. Its one of those core foundations to the larger exercise.  Learn how to model systems. By this I don't mean learn UML. I mean take any system. Say a car, break it down into how you would model it in software. Sketch it out on software. Model it from the driver's perspective, model it from the manufacturer's perspective. How are they different? How are they the same? Just like working out, do one of these every day and you should start to get better at them. And save them, revisit them in 3 months. What have you learned since then that would make you model it differently? Model it again with your new knowledge.  Nutrition, are you feeding your brain? Are you getting a good dose of veggies along with the sugar? Its fun to hear about new features of new frameworks and to get excited, but are you taking the time to learn the why behind the feature? Are you looking at other communities? I try to follow a wide variety of topics. I have a feed of RDBMS posts, of NoSQL posts, of Python, Ruby, Erlang, and .Net posts. What I really need is to broaden my own horizons a little bit and see what I can learn from outside the software development world. I also probably have some blogs that are not providing much value and need to be unsubscribed from. Like most things its a never ending journey.   Go out and meet people, find inspiration in others. Recently Ryan Rauh joined Dovetail, and I look forward to sucking all the knowledge I can out of his brain. Finding gaps in my knowledge and filling them in.  I also need to remember that when I go to conferences that I need to stop just hanging out with my friends, but I need to reach out and seek new people to meet and learn from. Its to easy to hang out with my friends and discuss what we consider to be relevant and interesting, but new voices are the things that we need to make the big leaps in knowledge.  Take the time to REALLY get to know something. Pick something you are interested in and learn as much as you can about it. If you love NHibernate, read about its history. Who was the first contributor? What was the motivation for its existence? What caused the motivation? As you explore and learn more keep turning over the stones you find that support the idea. As best as you can follow it as deep down the rabbit hole as you can. I find that when I do this I will learn something I would have never thought to seek out. Its those lessons that are beyond the surface of the product that can be another great source of ideas and learning.  And there you go. My keys to learning and being awesome. I hope they are helpful to you, they have been to me.";
      long startTime;

      text += text;
      text += text;
      text += text;
      text += text;
      text += text;
      
      sentenceModelInputStream = Program.class.getResourceAsStream(SENTENCE_MODEL_RESOURCE_NAME);
      
      startTime = System.currentTimeMillis();
      SentenceModel sentenceModel = new SentenceModel(sentenceModelInputStream);
      System.out.println("Loading model took: " + (System.currentTimeMillis() - startTime));

      startTime = System.currentTimeMillis();
      SentenceDetector sentenceDetector = new SentenceDetectorME(sentenceModel);
      System.out.println("Creating detector took: " + (System.currentTimeMillis() - startTime));

      startTime = System.currentTimeMillis();
      String[] sentences = sentenceDetector.sentDetect(text);
      System.out.println("Detecting sentences took: " + (System.currentTimeMillis() - startTime));

      System.out.println("Text length: " + text.length());
      System.out.println("Sentences count: " + sentences.length);
    }
    finally {
      if (sentenceModelInputStream != null) {
        sentenceModelInputStream.close();
      }
    }
  }
  
}
