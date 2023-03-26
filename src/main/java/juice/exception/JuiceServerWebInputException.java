package juice.exception;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.server.ResponseStatusException;

public class JuiceServerWebInputException extends ResponseStatusException {

		@Nullable
		private final MethodParameter parameter;


		/**
		 * Constructor with an explanation only.
		 */
		public JuiceServerWebInputException(String reason) {
				this(reason, null, null);
		}

		/**
		 * Constructor for a 400 error linked to a specific {@code MethodParameter}.
		 */
		public JuiceServerWebInputException(String reason, @Nullable MethodParameter parameter) {
				this(reason, parameter, null);
		}

		/**
		 * Constructor for a 400 error with a root cause.
		 */
		public JuiceServerWebInputException(String reason, @Nullable MethodParameter parameter, @Nullable Throwable cause) {
				super(HttpStatus.BAD_REQUEST, reason, cause);
				this.parameter = parameter;
		}


		/**
		 * Return the {@code MethodParameter} associated with this error, if any.
		 */
		@Nullable
		public MethodParameter getMethodParameter() {
				return this.parameter;
		}

}

