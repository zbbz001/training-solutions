package objectclass;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class SimpleBagTest {

    @Test
    public void testConstructor() {
        //Given
        SimpleBag bag = new SimpleBag();
        //Then
        Assert.assertThat(bag.isEmpty(), CoreMatchers.is(true));
        Assert.assertThat(bag.size(), CoreMatchers.equalTo(0));
    }


    @Test
    public void testPut() {
        //Given
        SimpleBag bag = new SimpleBag();
        //When
        bag.putItem("alma");
        bag.putItem((new Book("Rejtő Jenő", "Az ellopott cirkáló")));
        bag.putItem(new Beer("Borsodi", 239));
        //Then
        Assert.assertThat(bag.isEmpty(), CoreMatchers.equalTo(false));
        Assert.assertThat(bag.size(), CoreMatchers.equalTo(3));

    }

    @Test
    public void testIteration() {
        //Given
        SimpleBag bag = new SimpleBag();
        //When
        bag.putItem(new Beer("Heineken", 250));
        bag.putItem(new Book("Rejtő Jenő", "Az ellopott cirkáló"));
        bag.putItem(new Beer("Borsodi", 239));
        //Then
        while (bag.hasNext()) {
            Assert.assertThat(bag.next().getClass().toString(), StringContains.containsString("objectclass.B"));
        }
        Assert.assertThat(bag.getCursor(), CoreMatchers.equalTo(2));
    }

    @Test
    public void testContains() {
        //Given
        SimpleBag bag = new SimpleBag();
        //When
        bag.putItem(new Beer("Borsodi", 239));
        bag.putItem(new Book("Rejtő Jenő", "Az ellopott cirkáló"));
        //Then
        Assert.assertThat(bag.contains(new Beer("Borsodi", 239)), CoreMatchers.is(true));
        Assert.assertThat(bag.contains(new Book("Rejtő Jenő", "Az ellopott cirkáló")), CoreMatchers.is(true));
        Assert.assertThat(bag.contains(new Book("Rejtő Jenő", "A megkerült cirkáló")), CoreMatchers.is(false));
    }
}