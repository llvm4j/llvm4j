package dev.supergrecko.vexe.llvm.integration.jni

import dev.supergrecko.vexe.llvm.utils.TestSuite
import kotlin.test.assertTrue
import org.bytedeco.llvm.LLVM.LLVMModuleRef
import org.bytedeco.llvm.global.LLVM
import org.junit.jupiter.api.Test

/**
 * This utils is only here temporarily and is primarily used to
 * utils whether the LLVM bindings are working or not.
 */
internal class JNITest : TestSuite() {
    @Test
    fun `The raw bytedeco bindings work by themselves`() {
        LLVM.LLVMLinkInMCJIT()
        LLVM.LLVMInitializeNativeAsmPrinter()
        LLVM.LLVMInitializeNativeAsmParser()
        LLVM.LLVMInitializeNativeDisassembler()
        LLVM.LLVMInitializeNativeTarget()

        val mod = LLVM.LLVMModuleCreateWithName("test_module")
        val builder = LLVM.LLVMCreateBuilder()

        assertTrue { mod is LLVMModuleRef }

        LLVM.LLVMDisposeModule(mod)
        LLVM.LLVMDisposeBuilder(builder)
    }
}
