package app;

/**
 * This type represents the set of grades that can be obtained in a class.
 */
public enum Grade {

	A_PLUS {
		@Override
		public String toString() {
			return "A+";
		}
	},
	A, A_MINUS {
		@Override
		public String toString() {
			return "A-";
		}
	},
	B_PLUS {
		@Override
		public String toString() {
			return "B+";
		}
	},
	B, B_MINUS {
		@Override
		public String toString() {
			return "B-";
		}
	},
	C_PLUS {
		@Override
		public String toString() {
			return "C+";
		}
	},
	C, C_MINUS {
		@Override
		public String toString() {
			return "C-";
		}
	},
	D_PLUS {
		@Override
		public String toString() {
			return "D+";
		}
	},
	D, D_MINUS {
		@Override
		public String toString() {
			return "D-";
		}
	},
	F, UNKNOWN;

}
