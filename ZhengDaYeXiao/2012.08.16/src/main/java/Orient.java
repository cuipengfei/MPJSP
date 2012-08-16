/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/16/12
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Orient {
    W {
        public Orient left() {
            return S;
        }

        public Orient right() {
            return N;
        }
    }, E {
        public Orient left() {
            return N;
        }

        public Orient right() {
            return S;
        }

    }, S {
        public Orient left() {
            return E;
        }

        public Orient right() {
            return W;
        }

    }, N {
        public Orient left() {
            return W;
        }

        public Orient right() {
            return E;
        }
    };

    public Orient left() {
        return null;
    }


    public Orient right() {
        return null;
    }
}
