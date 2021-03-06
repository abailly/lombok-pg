import lombok.EnumId;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
class EnumIdPlain {
  public @RequiredArgsConstructor enum Status {
    WAITING(0),
    READY(1),
    SKIPPED((- 1)),
    COMPLETED(5),
    private static final java.util.Map<java.lang.Integer, Status> $CODE_LOOKUP = new java.util.HashMap<java.lang.Integer, Status>();
    private final @EnumId @Getter int code;
    static {
      for (Status status : Status.values()) 
        {
          $CODE_LOOKUP.put(status.code, status);
        }
    }
    <clinit>() {
    }
    private @java.lang.SuppressWarnings("all") Status(final int code) {
      super();
      this.code = code;
    }
    public static @java.lang.SuppressWarnings("all") Status findByCode(final int code) {
      if ($CODE_LOOKUP.containsKey(code))
          {
            return $CODE_LOOKUP.get(code);
          }
      throw new java.lang.IllegalArgumentException(java.lang.String.format("Enumeration \'Status\' has no value \'%s\'", code));
    }
    public @java.lang.SuppressWarnings("all") int getCode() {
      return this.code;
    }
  }
  EnumIdPlain() {
    super();
  }
}