package BetaMax.BetaMaxSample.extension

import org.testng.IHookable
import org.testng.IHookCallBack
import org.testng.ITestResult
import co.freeside.betamax.Recorder
import co.freeside.betamax.TapeMode
import co.freeside.betamax.MatchRule
import co.freeside.betamax.Betamax

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/18/12
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class NGRecorderG implements IHookable {
    @Override
    void run(IHookCallBack callBack, ITestResult testResult) {
        def annotation = testResult.getMethod().getMethod().getAnnotation(Betamax);
        Recorder recorder = new Recorder()
        recorder.withTape(annotation.tape(), [mode: annotation.mode(), match: annotation.match()]) {
            callBack.runTestMethod(testResult)
        }
    }
}
