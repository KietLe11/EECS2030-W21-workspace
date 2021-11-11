package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;
import model.*;

/*
 * Requirement: Any classes you create must reside in the `model` package and be imported properly.
 * For example, creating a new class `Foo` in the `model` package should result in:
 * 	import model.Foo;
 * 
 * All attributes you declare in the model classes must be private. 
 * 	If necessary, define public accessors/getters and/or mutators/setters for these private attributes. 
 */

public class StarterTests {
	/* 
	 * Programming Requirements:
	 * 
	 * 	- You are only allowed to use primitive arrays (e.g., int[], String[], Product[]) 
	 * 		for declaring attributes and implementing the idea of collections.
	 * 	- Any use of a Java library class or method is forbidden 
	 * 		(that is, use selections and loops to build your solution from scratch instead):
	 * 	- Here are some examples of forbidden classes/methods: 
	 * 		- Arrays class (e.g., Arrays.copyOf)
	 * 		- System class (e.g., System.arrayCopy)
	 * 		- ArrayList class
	 * 		- String class (e.g., substring).
	 * 	- The use of some library classes does not require an import statement, 
	 * 		but these classes are also forbidden to be used.
	 * 	- Here are the exceptions (library methods which you are allowed to use if needed):
	 * 		- String class (equals, format)
	 * 
	 * Violating the above programming requirements will result in a penalty (see lab instructions for details). 
	 * 
	 * Tests included in this class serve as documentation on how instances of an Apple AppStore operates.
	 * 
	 * Before attempting this lab, it is expected that you already completed background study materials:
	 * 	1. Review Tutorial Series on OOP in Java (Part 1 and Part 2): 
	 * 		https://www.eecs.yorku.ca/~jackie/teaching/tutorials/index.html#refurbished_store
	 * 	2. Written Notes on Reference-Typed, Multi-Valued Attributes:
	 * 		https://www.eecs.yorku.ca/~jackie/teaching/lectures/2021/F/EECS2030/notes/EECS2030_F21_Tracing_PointCollectorTester.pdf
	 * 	3. Written Notes on Inferring Classes from JUnit Tests:
	 * 		https://www.eecs.yorku.ca/~jackie/teaching/lectures/2021/F/EECS2030/notes/EECS2030_F21_Inferring_Classes_from_JUnit.pdf 
	 * 
	 * Be sure to also read the following sections from your Lab1 instructions PDF:
	 * 	- The `Requirements of this Lab` section (page 3) 
	 * 	- Section 2.3 The Building Design Problem
	 * 	- Section 2.4 Hints and Requirements
	 * 
	 * Programming IDEs such as Eclipse are able to fix some compilation errors for you. 
	 * However, you are advised to follow the guidance as specified in the written notes above
	 * to fix these compilation errors manually, because: 
	 * 	1) it helps you better understand how the intended classes and methods work together; and 
	 * 	2) you may be tested in a written test or exam without the assistance of IDEs.
	 */

	/*
	 * Tests related to the Channel class.
	 */ 
	
	@Test
	public void test_channel_01a() {
		/*
		 * Create a channel with the specified name and 
		 * 	maximum 50 followers and maximum 100 videos to release.
		 * See the lab manual to see what to expect when a preset maximum is exceeded.
		 */
		Channel ch = new Channel("Cafe Music BGM", 50, 100);
		assertEquals("Cafe Music BGM released no videos and has no followers.", ch.toString());
	}
	
	@Test
	public void test_channel_01b() {
		Channel ch = new Channel("Cafe Music BGM", 50, 100);
		
		/*
		 * `ch` releases two new videos.
		 */
		ch.releaseANewVideo("Monday Jazz");
		assertEquals("Cafe Music BGM released <Monday Jazz> and has no followers.", ch.toString());
		
		ch.releaseANewVideo("Tuesday Jazz");
		assertEquals("Cafe Music BGM released <Monday Jazz, Tuesday Jazz> and has no followers.", ch.toString());
	}
	
	/*
	 * Tests related to the Follower classes.
	 */ 
	
	@Test
	public void test_follower_01a() {
		/*
		 * Create a subscriber with the specified name and 
		 * 	maximum 20 channels to follow and maximum 40 videos to be recommended by the channels.
		 * See the lab manual to see what to expect when a preset maximum is exceeded.
		 */
		Follower f = new Subscriber("Alan", 20, 40);
		assertEquals("Subscriber Alan follows no channels and has no recommended videos.", f.toString());
	}
	
	@Test
	public void test_follower_01b() {
		/*
		 * Create a monitor with the specified name and maximum 20 channels to follow.
		 * See the lab manual to see what to expect when a preset maximum is exceeded.
		 */
		Follower f = new Monitor("Stat Sensor A", 20);
		assertEquals("Monitor Stat Sensor A follows no channels.", f.toString());
	}
	
	/*
	 * More tests related to the Channel class.
	 */ 
	
	@Test
	public void test_channel_01c() { 
		/*
		 * Note that the two channels are set with different maximums for
		 * 	the allowed numbers of followers and videos to release. 
		 */
		Channel ch1 = new Channel("Cafe Music BGM", 50, 100);
		Channel ch2 = new Channel("I Love You Venice", 60, 135);
		
		/*
		 * Note that the followers are set with different maximums for the allowed numbers of channels.
		 */
		Follower f1 = new Subscriber("Alan", 20, 40);
		Follower f2 = new Monitor("Stat Sensor A", 60); 
		
		/* 
		 * Let `f1` follow `ch1` (which updates both the context object `ch1` and argument object `f1`). 
		 * 
		 * You can assume that a follower, once added to a channel, will not be added to that channel again. 
		 */
		ch1.follow(f1);
		assertEquals("Cafe Music BGM released no videos and is followed by [Subscriber Alan].", ch1.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM] and has no recommended videos.", f1.toString());
		
		/* 
		 * Let `f2` follow `ch1` (which updates both the context object `ch1` and argument object `f2`). 
		 */
		ch1.follow(f2);
		assertEquals("Cafe Music BGM released no videos and is followed by [Subscriber Alan, Monitor Stat Sensor A].", ch1.toString());
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM].", f2.toString());
		
		/* 
		 * Let `f2` follow `ch2` (which updates both the context object `ch2` and argument object `f2`). 
		 */
		ch2.follow(f2);
		assertEquals("I Love You Venice released no videos and is followed by [Monitor Stat Sensor A].", ch2.toString());
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM, I Love You Venice].", f2.toString());
		
		/* 
		 * Let `f1` follow `ch2` (which updates both the context object `ch2` and argument object `f1`). 
		 */
		ch2.follow(f1);
		assertEquals("I Love You Venice released no videos and is followed by [Monitor Stat Sensor A, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and has no recommended videos.", f1.toString());
		
		/*
		 * Jackie's suggestion: You may test more cases of letting multiple subscribers and/or monitors follow multiple channels. 
		 */
	}
	
	@Test
	public void test_channel_01d() { 
		Channel ch1 = new Channel("Cafe Music BGM", 50, 100);
		Channel ch2 = new Channel("I Love You Venice", 60, 135);
		
		Follower f1 = new Subscriber("Alan", 20, 40);
		Follower f2 = new Monitor("Stat Sensor A", 60);
		
		ch1.follow(f1);
		ch1.follow(f2);
		ch2.follow(f2);
		ch2.follow(f1);
		
		assertEquals("Cafe Music BGM released no videos and is followed by [Subscriber Alan, Monitor Stat Sensor A].", ch1.toString());
		assertEquals("I Love You Venice released no videos and is followed by [Monitor Stat Sensor A, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and has no recommended videos.", f1.toString());
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM, I Love You Venice].", f2.toString());
		
		/*
		 * Let `f1` stop following `ch1` (which updates both the context object `ch1` and argument object `f1`).
		 */
		ch1.unfollow(f1);
		
		assertEquals("Cafe Music BGM released no videos and is followed by [Monitor Stat Sensor A].", ch1.toString());
		assertEquals("I Love You Venice released no videos and is followed by [Monitor Stat Sensor A, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [I Love You Venice] and has no recommended videos.", f1.toString());
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM, I Love You Venice].", f2.toString());
		
		/*
		 * Let `f1` stop following `ch2` (which updates both the context object `ch2` and argument object `f1`).
		 */
		ch2.unfollow(f1);
		assertEquals("Cafe Music BGM released no videos and is followed by [Monitor Stat Sensor A].", ch1.toString());
		assertEquals("I Love You Venice released no videos and is followed by [Monitor Stat Sensor A].", ch2.toString());
		assertEquals("Subscriber Alan follows no channels and has no recommended videos.", f1.toString());
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM, I Love You Venice].", f2.toString());
		
		/*
		 * Let `f2` stop following `ch2` (which updates both the context object `ch2` and argument object `f2`).
		 */
		ch2.unfollow(f2);
		assertEquals("Cafe Music BGM released no videos and is followed by [Monitor Stat Sensor A].", ch1.toString());
		assertEquals("I Love You Venice released no videos and has no followers.", ch2.toString());
		assertEquals("Subscriber Alan follows no channels and has no recommended videos.", f1.toString());
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM].", f2.toString());
		
		
		Follower f3 = new Subscriber("Mark", 20, 45);
		ch2.follow(f3);
		assertEquals("Subscriber Mark follows [I Love You Venice] and has no recommended videos.", f3.toString());
		assertEquals("I Love You Venice released no videos and is followed by [Subscriber Mark].", ch2.toString());
		assertEquals("Cafe Music BGM released no videos and is followed by [Monitor Stat Sensor A].", ch1.toString());
		

		ch1.unfollow(f3);
		/*
		 * Since `f3` is not following `ch1`, unfollowing it should have no effect.
		 */
		assertEquals("Subscriber Mark follows [I Love You Venice] and has no recommended videos.", f3.toString());
		assertEquals("I Love You Venice released no videos and is followed by [Subscriber Mark].", ch2.toString());
		assertEquals("Cafe Music BGM released no videos and is followed by [Monitor Stat Sensor A].", ch1.toString());
		
		/*
		 * Jackie's suggestions: 
		 * 	1. You may test more cases of letting a follower stop following a channel
		 * 		(in cases where the follower is in the beginning, middle, or end of the channel's follower list, and
		 * 		 in cases where the channel is in the beginning, middle, or end of the follower's channel list).
		 *  2. You may test more cases of unfollowing a subscriber or monitor from a channel which it does not follow.
		 */
	}
	
	@Test
	public void test_channel_02a() { 
		Channel ch = new Channel("Cafe Music BGM", 50, 100);
		assertEquals("Cafe Music BGM released no videos and has no followers.", ch.toString());
		
		/* 
		 * You can assume that no duplicated video names will be released across all channels. 
		 * That is, names of videos released by all channels are unique.
		 * 
		 * Assume that channel videos, once released, will not be removed.
		 */
		ch.releaseANewVideo("Jazz Piano Radio");
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and has no followers.", ch.toString());
		
		ch.releaseANewVideo("Starbucks Music Playlist 2021");
		assertEquals("Cafe Music BGM released <Jazz Piano Radio, Starbucks Music Playlist 2021> and has no followers.", ch.toString());
		
		Follower f1 = new Subscriber("Alan", 20, 40);
		Follower f2 = new Monitor("Stat Sensor A", 60);
		
		/*
		 * Given that `f1` and `f2` only start following `ch` after it released the two videos,
		 * 	those two videos will not be recommended to `f1` and `f2`.
		 * 
		 * That is, a follower is only recommended videos that are released after they start following a channel.
		 */
		
		ch.follow(f1);
		assertEquals("Cafe Music BGM released <Jazz Piano Radio, Starbucks Music Playlist 2021> and is followed by [Subscriber Alan].", ch.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM] and has no recommended videos.", f1.toString());
		assertEquals("Monitor Stat Sensor A follows no channels.", f2.toString());
		
		ch.follow(f2);
		assertEquals("Cafe Music BGM released <Jazz Piano Radio, Starbucks Music Playlist 2021> and is followed by [Subscriber Alan, Monitor Stat Sensor A].", ch.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM] and has no recommended videos.", f1.toString());
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM].", f2.toString());
	}
	
	@Test
	public void test_channel_02b() { 
		Channel ch1 = new Channel("Cafe Music BGM", 50, 100);
		Channel ch2 = new Channel("I Love You Venice", 60, 135);
		
		Follower f1 = new Subscriber("Alan", 20, 40); 
		Follower f2 = new Monitor("Stat Sensor A", 30);
		Follower f3 = new Subscriber("Mark", 20, 40);
		
		ch1.follow(f1); 
		ch2.follow(f1);
		ch2.follow(f2);
		ch1.follow(f2);
		ch2.follow(f3);
		ch1.follow(f3);
		
		assertEquals("Cafe Music BGM released no videos and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch1.toString());
		assertEquals("I Love You Venice released no videos and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and has no recommended videos.", f1.toString());
		assertEquals("Monitor Stat Sensor A follows [I Love You Venice, Cafe Music BGM].", f2.toString());
		assertEquals("Subscriber Mark follows [I Love You Venice, Cafe Music BGM] and has no recommended videos.", f3.toString());
		
		/*
		 * When a video is released by the channel, it is immediately recommended to all its subscribers (not monitors).
		 * 
		 * Hints on implementing `releaseANewVideo`: 
		 * 	See the two updates expressed in the following two assertions.
		 */ 
		ch1.releaseANewVideo("Jazz Piano Radio");
		/* Update 1: video release updated on `ch1` */
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch1.toString());
		/* Update 2: video recommendation updated on all subscribers: `f1` and `f3` */
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio>.", f1.toString());
		assertEquals("Subscriber Mark follows [I Love You Venice, Cafe Music BGM] and is recommended <Jazz Piano Radio>.", f3.toString());
		
		/* no changes on the other channel and the monitor */
		assertEquals("I Love You Venice released no videos and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch2.toString());
		assertEquals("Monitor Stat Sensor A follows [I Love You Venice, Cafe Music BGM].", f2.toString());
		
		ch2.releaseANewVideo("Baroque Live Music 24/7");
		/* Update 1: video release updated on `ch2` */
		assertEquals("I Love You Venice released <Baroque Live Music 24/7> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch2.toString());
		/* Update 2: video recommendation updated on all subscribers: `f1` and `f3` */
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", f1.toString());
		assertEquals("Subscriber Mark follows [I Love You Venice, Cafe Music BGM] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", f3.toString());
		
		/* no changes on the other channel and the monitor */
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch1.toString());
		assertEquals("Monitor Stat Sensor A follows [I Love You Venice, Cafe Music BGM].", f2.toString());
		
		/*
		 * Jackie's suggestion: You may test more cases of a channel's new video release causing
		 * 							more than one subscribers to be updated on their lists of recommended videos. 
		 */
	}
	
	@Test
	public void test_channel_03a() { 
		Channel ch1 = new Channel("Cafe Music BGM", 50, 100);
		Channel ch2 = new Channel("I Love You Venice", 60, 135);
		
		Subscriber sub1 = new Subscriber("Alan", 20, 40); 
		Subscriber sub2 = new Subscriber("Mark", 20, 40);
		Monitor mon1 = new Monitor("Stat Sensor A", 30);
		
		ch1.follow(sub1); 
		ch1.follow(mon1);
		ch1.follow(sub2);
		
		ch2.follow(mon1);
		ch2.follow(sub2);
		ch2.follow(sub1);
		
		
		ch1.releaseANewVideo("Jazz Piano Radio");
		ch2.releaseANewVideo("Baroque Live Music 24/7");
		
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch1.toString());
		assertEquals("I Love You Venice released <Baroque Live Music 24/7> and is followed by [Monitor Stat Sensor A, Subscriber Mark, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub1.toString());
		assertEquals("Subscriber Mark follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub2.toString());
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM, I Love You Venice].", mon1.toString()); 
		
		/* 
		 * Subscriber `sub1` watched Jazz Piano Radio for 20 minutes. 
		 * 
		 * After a subscriber watched a recommended video of a channel, 
		 * 	the watch time is immediately used to update the statistics of all that channel's monitors (not subscribers).
		 * 
		 * Assume that the second argument of method `watch` is always an integer specifying the watch time in terms of minutes. 
		 * 
		 * Since video names across all channels are assumed to be unique, 
		 * 	the `watch` method should be able to figure out to which channel the specified video name belongs.
		 */
		sub1.watch("Jazz Piano Radio", 20);
		/* 
		 * Statistics for the watched video is updated for `mon1`.
		 * For the average watch time, display the value with two digits after the decimal point. 
		 */ 
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM {#views: 1, max watch time: 20, avg watch time: 20.00}, I Love You Venice].", mon1.toString());
		/* All other channels and subscribers remain unchanged. */
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch1.toString());
		assertEquals("I Love You Venice released <Baroque Live Music 24/7> and is followed by [Monitor Stat Sensor A, Subscriber Mark, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub1.toString());
		assertEquals("Subscriber Mark follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub2.toString());
		
		/*
		 * Subscriber `sub2` watched Jazz Piano Radio for 30 minutes. 
		 */
		sub2.watch("Jazz Piano Radio", 30);
		/* 
		 * Statistics for the watched video is updated for `mon1`.
		 */
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM {#views: 2, max watch time: 30, avg watch time: 25.00}, I Love You Venice].", mon1.toString());
		/* All other channels and subscribers remain unchanged. */
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch1.toString());
		assertEquals("I Love You Venice released <Baroque Live Music 24/7> and is followed by [Monitor Stat Sensor A, Subscriber Mark, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub1.toString());
		assertEquals("Subscriber Mark follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub2.toString());
		
		/*
		 * Subscriber `sub1` watched Jazz Piano Radio again for 15 minutes. 
		 */
		sub1.watch("Jazz Piano Radio", 15);
		/* 
		 * Statistics for the watched video is updated for `mon1`.
		 */
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM {#views: 3, max watch time: 30, avg watch time: 21.67}, I Love You Venice].", mon1.toString());
		/* All other channels and subscribers remain unchanged. */
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch1.toString());
		assertEquals("I Love You Venice released <Baroque Live Music 24/7> and is followed by [Monitor Stat Sensor A, Subscriber Mark, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub1.toString());
		assertEquals("Subscriber Mark follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub2.toString());
		
		/*
		 * Subscriber `sub2` watched Baroque Live Music 24/7 for 11 minutes. 
		 */
		sub2.watch("Baroque Live Music 24/7", 11);
		/* 
		 * Statistics for the watched video is updated for `mon1`.
		 */
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM {#views: 3, max watch time: 30, avg watch time: 21.67}, I Love You Venice {#views: 1, max watch time: 11, avg watch time: 11.00}].", mon1.toString());
		/* All other channels and subscribers remain unchanged. */
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch1.toString());
		assertEquals("I Love You Venice released <Baroque Live Music 24/7> and is followed by [Monitor Stat Sensor A, Subscriber Mark, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub1.toString());
		assertEquals("Subscriber Mark follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub2.toString());
		/*
		 * Subscriber `sub1` watched Baroque Live Music 24/7 for 8 minutes. 
		 */
		sub1.watch("Baroque Live Music 24/7", 8);
		/* 
		 * Statistics for the watched video is updated for `mon1`.
		 */
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM {#views: 3, max watch time: 30, avg watch time: 21.67}, I Love You Venice {#views: 2, max watch time: 11, avg watch time: 9.50}].", mon1.toString());
		/* All other channels and subscribers remain unchanged. */
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch1.toString());
		assertEquals("I Love You Venice released <Baroque Live Music 24/7> and is followed by [Monitor Stat Sensor A, Subscriber Mark, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub1.toString());
		assertEquals("Subscriber Mark follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub2.toString());
		
		/*
		 * Subscriber `sub2` watched Baroque Live Music 24/7 again for 18 minutes. 
		 */
		sub2.watch("Baroque Live Music 24/7", 18);
		/* 
		 * Statistics for the watched video is updated for `mon1`.
		 */
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM {#views: 3, max watch time: 30, avg watch time: 21.67}, I Love You Venice {#views: 3, max watch time: 18, avg watch time: 12.33}].", mon1.toString());
		/* All other channels and subscribers remain unchanged. */
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch1.toString());
		assertEquals("I Love You Venice released <Baroque Live Music 24/7> and is followed by [Monitor Stat Sensor A, Subscriber Mark, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub1.toString());
		assertEquals("Subscriber Mark follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub2.toString());
	}
	
	@Test
	public void test_channel_03b() { 
		Channel ch1 = new Channel("Cafe Music BGM", 50, 100);
		Channel ch2 = new Channel("I Love You Venice", 60, 135);
		
		Subscriber sub1 = new Subscriber("Alan", 20, 40); 
		Subscriber sub2 = new Subscriber("Mark", 20, 40);
		Monitor mon1 = new Monitor("Stat Sensor A", 30);
		
		ch1.follow(sub1); 
		ch1.follow(mon1);
		ch1.follow(sub2);
		
		ch2.follow(mon1);
		ch2.follow(sub2);
		ch2.follow(sub1);
		
		
		ch1.releaseANewVideo("Jazz Piano Radio");
		ch2.releaseANewVideo("Baroque Live Music 24/7");
		
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch1.toString());
		assertEquals("I Love You Venice released <Baroque Live Music 24/7> and is followed by [Monitor Stat Sensor A, Subscriber Mark, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub1.toString());
		assertEquals("Subscriber Mark follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub2.toString());
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM, I Love You Venice].", mon1.toString()); 
		
		/* 
		 * Subscriber `sub1` watched Jazz Piano Radio for 40 minutes. 
		 */
		sub1.watch("Jazz Piano Radio", 40);
		
		/* 
		 * Statistics for the watched video is updated for `mon1`.
		 * For the average watch time, display with two digits after the decimal point. 
		 */ 
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM {#views: 1, max watch time: 40, avg watch time: 40.00}, I Love You Venice].", mon1.toString());
		/* All other channels and subscribers remain unchanged. */
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark].", ch1.toString());
		assertEquals("I Love You Venice released <Baroque Live Music 24/7> and is followed by [Monitor Stat Sensor A, Subscriber Mark, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub1.toString());
		assertEquals("Subscriber Mark follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub2.toString());
		
		Monitor mon2 = new Monitor("Stat Sensor B", 30);
		assertEquals("Monitor Stat Sensor B follows no channels.", mon2.toString());
		
		/*
		 * Let `mon2` start following `ch1`, meaning that
		 * 	its statistics only covers the watch times happening from now on.
		 */
		ch1.follow(mon2);
		assertEquals("Monitor Stat Sensor B follows [Cafe Music BGM].", mon2.toString());
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark, Monitor Stat Sensor B].", ch1.toString());
		
		/*
		 * Subscriber `sub2` watched Jazz Piano Radio for 30 minutes. 
		 */
		sub2.watch("Jazz Piano Radio", 30);

		/* 
		 * Statistics for the watched video is updated for `mon1` and `mon2`.
		 */
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM {#views: 2, max watch time: 40, avg watch time: 35.00}, I Love You Venice].", mon1.toString());
		assertEquals("Monitor Stat Sensor B follows [Cafe Music BGM {#views: 1, max watch time: 30, avg watch time: 30.00}].", mon2.toString());
		/* All other channels and subscribers remain unchanged. */
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark, Monitor Stat Sensor B].", ch1.toString());
		assertEquals("I Love You Venice released <Baroque Live Music 24/7> and is followed by [Monitor Stat Sensor A, Subscriber Mark, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub1.toString());
		assertEquals("Subscriber Mark follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub2.toString());
		
		/*
		 * Subscriber `sub1` watched Jazz Piano Radio again for 15 minutes. 
		 */
		sub2.watch("Jazz Piano Radio", 15);
		
		/* 
		 * Statistics for the watched video is updated for `mon1` and `mon2`.
		 */
		assertEquals("Monitor Stat Sensor A follows [Cafe Music BGM {#views: 3, max watch time: 40, avg watch time: 28.33}, I Love You Venice].", mon1.toString());
		assertEquals("Monitor Stat Sensor B follows [Cafe Music BGM {#views: 2, max watch time: 30, avg watch time: 22.50}].", mon2.toString());
		/* All other channels and subscribers remain unchanged. */
		assertEquals("Cafe Music BGM released <Jazz Piano Radio> and is followed by [Subscriber Alan, Monitor Stat Sensor A, Subscriber Mark, Monitor Stat Sensor B].", ch1.toString());
		assertEquals("I Love You Venice released <Baroque Live Music 24/7> and is followed by [Monitor Stat Sensor A, Subscriber Mark, Subscriber Alan].", ch2.toString());
		assertEquals("Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub1.toString());
		assertEquals("Subscriber Mark follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio, Baroque Live Music 24/7>.", sub2.toString());
	}
}