package org.opentripplanner.netex.index.api;


/**
 * This interface is used to make validation rules witch can be passed to a hierarchical map. The
 * rule is applied to all local elements. Depending on the validation status on of 3 actions is
 * performed for each element in the map:
 * <ol>
 *   <li>
 *     OK - nothing is done
 *   </li>
 *   <li>
 *     WARN - A warning message is passed on to the log message consumer.
 *   </li>
 *   <li>
 *     DISCARD - The key/value pair is removed from the local map, and a waring is passed on to
 *     the log message consumer.
 *   </li>
 * </ol>
 */
public interface HMapValidationRule<K, V> {
  enum Status {
    /** Element is OK. */
    OK,
    /** Log warning */
    WARN,
    /** Log warning and remove element from HierarchicalMap. */
    DISCARD
  }

  /**
   * Validate and return status, the caller will take the appropriate acction according to  the
   * retuned status.
   */
  Status validate(K key, V value);

  /**
   * The rule should provide a log message to use if the validation fails.
   */
  String logMessage(K key, V value);
}
