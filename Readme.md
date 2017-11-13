# Notes about the JPA implementation

Using @EmbeddedId and @GeneratedValue will not work (not required by the JPA spec).

The idea is to move from a field-based definition (@annotations on fields) to a property based one (@annotations on methods).

This allows us to define @Id on `private int getIdForHibernate() { return this.id.toInteger() }` (and conversly for the set). Essentially, hibernate thinks you use an int, but you map it behind the scenes to a value object.

The trick is to make all methods you don't want to expose private. This has the downside of binding the hibernate's implementation to an "int" representation, but this is what you would do anyways since you need to define the column as INT. It would still break the ripple effect of having to change the id's type.

One downside of this approach is that it will try to map all methods that start with get/set/is to a column. You need to you `@Transient` on them to ignore them.

Unfortunately, this is the best approach I have found to use value objects as identifiers. Compared to the in-memory version of this code, the ID type still isn't leaked in the domain, only in the persistence layer.

