package dev.supergrecko.vexe.llvm.ir.callbacks

import dev.supergrecko.vexe.llvm.internal.contracts.Callback
import dev.supergrecko.vexe.llvm.internal.util.wrap
import dev.supergrecko.vexe.llvm.ir.DiagnosticInfo
import org.bytedeco.javacpp.Pointer
import org.bytedeco.llvm.LLVM.LLVMDiagnosticHandler
import org.bytedeco.llvm.LLVM.LLVMDiagnosticInfoRef

/**
 * This callback is invoked when the backend needs to report anything to the
 * user
 *
 * [DiagnosticInfo] The associated DiagnosticInfo reporter
 * [Pointer] The payload which was sent with the setter for this callback
 */
public typealias DiagnosticHandlerCallback = (DiagnosticInfo?, Pointer?) -> Unit

public class DiagnosticHandlerBase(
    private val callback: DiagnosticHandlerCallback
) : LLVMDiagnosticHandler(), Callback {
    public override fun call(arg0: LLVMDiagnosticInfoRef?, arg1: Pointer?) {
        val di = wrap(arg0) { DiagnosticInfo(it) }

        callback.invoke(di, arg1)
    }
}
