package usantatecla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {
  
  private Point left = new Point(-2.2);
  private Point right = new Point(4.4);

  @BeforeEach
  public void before(){
    this.left = new Point(-2.2);
    this.right = new Point(4.4);
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
    Interval interval = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));
    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
    Interval interval = new IntervalBuilder().closed(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));
    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
    Interval interval = new IntervalBuilder().open(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));
    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
    Interval interval = new IntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));
    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervalClosedClosedIntersectedWhenIsIntersectedThenTrue() {
    Interval interval = new IntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();
    Interval anotherInterval = new IntervalBuilder().closed(point(-2.2)).closed(point(5.0)).build();
    assertTrue(interval.isIntersected(anotherInterval));
    anotherInterval = new IntervalBuilder().closed(point(-2.3)).closed(point(4.3)).build();
    assertTrue(interval.isIntersected(anotherInterval));
  }

  @Test
  public void givenIntervalClosedClosedNotIntersectedWhenIsIntersectedThenFalse() {
    Interval interval = new IntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();
    Interval anotherInterval = new IntervalBuilder().closed(point(-2.4)).closed(point(-2.3)).build();
    assertFalse(interval.isIntersected(anotherInterval));
    anotherInterval = new IntervalBuilder().closed(point(4.41)).closed(point(4.41)).build();
    assertFalse(interval.isIntersected(anotherInterval));
  }

  @Test
  public void givenIntervalOpenOpenIntersectedWhenIsIntersectedThenTrue() {
    Interval interval = new IntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();
    Interval anotherInterval = new IntervalBuilder().open(point(-2.3)).open(point(4.5)).build();
    assertTrue(interval.isIntersected(anotherInterval));
    anotherInterval = new IntervalBuilder().open(point(-2.19)).open(point(4.5)).build();
    assertTrue(interval.isIntersected(anotherInterval));
  }

  @Test
  public void givenIntervalOpenOpenNotIntersectedWhenIsIntersectedThenFalse() {
    Interval interval = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    Interval anotherInterval = new IntervalBuilder().open(point(-2.211)).open(point(-2.21)).build();
    assertFalse(interval.isIntersected(anotherInterval));
    anotherInterval = new IntervalBuilder().open(point(4.41)).open(point(4.42)).build();
    assertFalse(interval.isIntersected(anotherInterval));
  }

  @Test
  public void givenTwoIntersectedIntervalsWhenIntersectionThenReturnIntersectedInterval() {
    Interval interval = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    Interval anotherInterval = new IntervalBuilder().open(point(-2.3)).open(point(4.5)).build();
    Interval intersectedInterval = interval.intersection(anotherInterval);
    Interval expectedInterval = interval;
    assertEquals(intersectedInterval, expectedInterval);
    anotherInterval = new IntervalBuilder().open(point(-2.1)).open(point(4.5)).build();
    intersectedInterval = interval.intersection(anotherInterval);
    expectedInterval = new IntervalBuilder().open(point(-2.1)).open(point(4.4)).build();
    assertEquals(intersectedInterval, expectedInterval);
  }

  @Test
  public void givenTwoNotIntersectedIntervalsWhenIntersectionThenReturnNull() {
    Interval interval = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    Interval anotherInterval = new IntervalBuilder().open(point(-2.3)).open(point(-2.21)).build();
    Interval intersectedInterval = interval.intersection(anotherInterval);
    assertNull(intersectedInterval);
    anotherInterval = new IntervalBuilder().open(point(4.41)).open(point(4.42)).build();
    intersectedInterval = interval.intersection(anotherInterval);
    assertNull(intersectedInterval);
  }

  private double point(double value) {
    return value;
  }
}