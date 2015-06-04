package generic;

/**
 * Created by dc on 2015/6/4.
 * Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded. The produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.
 * Insert type casts if necessary to preserve type safety.
 * Generate bridge methods to preserve polymorphism in extended generic types.
 * Type erasure ensures that no new classes are created for parameterized types; consequently, generics incur no runtime overhead.
 */
public class TypeErasure {

}
