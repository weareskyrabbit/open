public class RuleBook<T> {
	Set<Rule<T>> rules = new HashSet<>();
	public RuleBook setRule(Rule<T> rule) {
		rules.add(rule);
		return this;
	}
	public Set<State> next(State state, T input) {
		return rules.stream()
			    .filter(rule -> rule.isApplicableTo(state, input))
			    .map(Rule::next)
			    .collect(Collectors.toSet());
	}
}
