package dev.supergrecko.kllvm.core.types

import dev.supergrecko.kllvm.core.enumerations.TypeKind
import dev.supergrecko.kllvm.core.typedefs.Context
import dev.supergrecko.kllvm.core.typedefs.Type
import org.bytedeco.llvm.LLVM.LLVMTypeRef
import org.bytedeco.llvm.global.LLVM

public class MetadataType public constructor(context: Context = Context.getGlobalContext()) : Type() {
    init {
        ref = LLVM.LLVMMetadataTypeInContext(context.ref)
        requireKind(TypeKind.Metadata)
    }

    public constructor(llvmType: LLVMTypeRef) : this() {
        ref = llvmType
    }
}
